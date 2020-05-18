package com.battcn.Prototype;

import java.io.*;
import java.util.List;


class Address implements Cloneable,Serializable {

    private static final long serialVersionUID = 783202091017893997L;
    /**
     * 详细地址
     */
    private String description;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Address() {
    }

    public Address(String description) {
        this.description = description;
    }

    @Override
    protected Address clone() throws CloneNotSupportedException {
        return (Address) super.clone();
    }

    @Override
    public String toString() {
        return "Address{" +
                "description='" + description + '\'' +
                '}';
    }
}

/**
 * @author Levin
 */
public class Customer implements Cloneable, Serializable {

    private static final long serialVersionUID = 783202091017893997L;

    private int id;
    private String name;
    private Address address;
    private List<String> hobbies;

    @Override
    protected Customer clone() throws CloneNotSupportedException {
        return (Customer) super.clone();
    }

    protected Customer shallow() throws CloneNotSupportedException {
        return (Customer) super.clone();
    }

    protected Customer deep() throws CloneNotSupportedException {
        Customer clone = (Customer) super.clone();
        clone.setAddress(clone.getAddress().clone());
        return clone;
    }

    protected Customer deepCopy() throws Exception {
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        ObjectOutputStream out = new ObjectOutputStream(bos);
        out.writeObject(this);
        ByteArrayInputStream bis = new ByteArrayInputStream(bos.toByteArray());
        ObjectInputStream in = new ObjectInputStream(bis);
        return (Customer) in.readObject();
    }

    /**
     * 需要注意,它只是一个方法,对方法名不会强约束
     *
     * @return
     * @throws CloneNotSupportedException
     */
    protected Customer myClone() throws CloneNotSupportedException {
        return (Customer) super.clone();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public List<String> getHobbies() {
        return hobbies;
    }

    public void setHobbies(List<String> hobbies) {
        this.hobbies = hobbies;
    }

    public Customer() {
    }

    public Customer(int id, String name, Address address, List<String> hobbies) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.hobbies = hobbies;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", address=" + address +
                ", hobbies=" + hobbies +
                ",  customer-hashCode=" + this.hashCode() +
                ",  address-hashCode=" + this.address.hashCode() +
                '}';
    }
}
