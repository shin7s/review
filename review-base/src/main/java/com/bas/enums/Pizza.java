package com.bas.enums;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.PrettyPrinter;
import com.fasterxml.jackson.core.util.DefaultPrettyPrinter;
import com.fasterxml.jackson.core.util.MinimalPrettyPrinter;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Data;
import lombok.Getter;

import java.io.IOException;
import java.util.EnumSet;
import java.util.List;
import java.util.stream.Collectors;

@Data
public class Pizza {

    private static EnumSet<PizzaStatus> undeliveredPizzaStatuses =
            EnumSet.of(PizzaStatus.ORDERED, PizzaStatus.READY);

    private PizzaStatus status;

    static ObjectMapper mapper = new ObjectMapper();

    public static String getJsonString(Pizza pz) throws JsonProcessingException {
        //DefaultPrettyPrinter defaultPrettyPrinter = new DefaultPrettyPrinter();
        //defaultPrettyPrinter.indentObjectsWith(new DefaultPrettyPrinter.Indenter() {
        //    @Override
        //    public void writeIndentation(JsonGenerator jg, int level) throws IOException {
        //        jg.writeRaw("\n");
        //        for (int i = 0; i < level; i++) {
        //            jg.writeRaw(" ");
        //        }
        //    }
        //
        //    @Override
        //    public boolean isInline() {
        //        return false;
        //    }
        //});
        //mapper.setDefaultPrettyPrinter(defaultPrettyPrinter);
        return mapper.writerWithDefaultPrettyPrinter().writeValueAsString(pz);
    }

    public boolean isDeliverable() {
        return this.status.isReady();
    }

    public void printTimeToDeliver() {
        System.out.println("Time to delivery is " +
                this.getStatus().getTimeToDelivery() + " days");
    }

    public static List<Pizza> getAllUndeliveredPizzas(List<Pizza> input) {
        return input.stream().filter(
                (s) -> undeliveredPizzaStatuses.contains(s.getStatus()))
                .collect(Collectors.toList());
    }

    public void deliver() {
        if (isDeliverable()) {
            PizzaDeliverySystemConfiguration.getInstance().getDeliveryStrategy()
                    .deliver(this);
            this.setStatus(PizzaStatus.DELIVERED);
        }
    }

    // Methods that set and get the status variable.

    @Getter
    @JsonFormat(shape = JsonFormat.Shape.OBJECT)
    public enum PizzaStatus {
        ORDERED(5) {
            public boolean isOrdered() {
                return true;
            }
        },
        READY(2) {
            public boolean isOrdered() {
                return true;
            }
        },
        DELIVERED(0) {
            public boolean isOrdered() {
                return true;
            }
        };

        private int timeToDelivery;

        public boolean isOrdered() {
            return false;
        }

        public boolean isReady() {
            return false;
        }

        public boolean isDelivered() {
            return false;
        }

        @JsonProperty("timeToDelivery")
        public int getTimeToDelivery() {
            return timeToDelivery;
        }

        private PizzaStatus(int timeToDelivery) {
            this.timeToDelivery = timeToDelivery;
        }

    }
}
