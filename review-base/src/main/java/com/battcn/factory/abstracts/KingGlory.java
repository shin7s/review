package com.battcn.factory.abstracts;


interface Linux {
    void controller();
}

interface Windows {
    void controller();
}

class LinuxController implements Linux {
    @Override
    public void controller() {
        System.out.println("Linux 控制 《王者荣耀》");
    }
}

class WindowsController implements Windows {
    @Override
    public void controller() {
        System.out.println("Windows 控制 《王者荣耀》");
    }
}

interface AbstractFactory {
    Linux installLinux();

    Windows installWindows();
}

class OperationFactory implements AbstractFactory {

    @Override
    public Linux installLinux() {
        System.out.println("安装Linux操作控制系统");
        return new LinuxController();
    }

    @Override
    public Windows installWindows() {
        System.out.println("安装Windows操作控制系统");
        return new WindowsController();
    }
}

class InterfaceFactory implements AbstractFactory {
    @Override
    public Linux installLinux() {
        System.out.println("安装Linux界面控制系统");
        return new LinuxController();
    }

    @Override
    public Windows installWindows() {
        System.out.println("安装Windows界面控制系统");
        return new WindowsController();
    }
}

public class KingGlory {

    public static void main(String[] args) {

        AbstractFactory operationFactory = new OperationFactory();
        operationFactory.installLinux().controller();
        operationFactory.installWindows().controller();
        System.out.println("========================================================");
        AbstractFactory interfaceFactory = new InterfaceFactory();
        interfaceFactory.installLinux().controller();
        interfaceFactory.installWindows().controller();

    }
}