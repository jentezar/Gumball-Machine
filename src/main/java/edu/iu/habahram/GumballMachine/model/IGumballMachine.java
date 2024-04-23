package edu.iu.habahram.GumballMachine.model;

public interface IGumballMachine {
    TransitionResult insertQuarter();
    TransitionResult ejectQuarter();
    TransitionResult turnCrank();

    TransitionResult refill(int balls);

    void changeTheStateTo(GumballMachineState name);
    Integer getCount();
    String getTheStateName();

    void releaseBall();

    void setCount(int balls);
}