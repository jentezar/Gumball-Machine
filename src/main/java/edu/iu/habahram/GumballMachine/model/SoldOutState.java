package edu.iu.habahram.GumballMachine.model;

public class SoldOutState implements IState {
    private IGumballMachine gumballMachine;

    public SoldOutState(IGumballMachine gumballMachine) {
        this.gumballMachine = gumballMachine;
    }

    @Override
    public TransitionResult insertQuarter() {
        String message = "You can't insert a quarter, the machine is sold out";
        boolean succeeded = false;
        return new TransitionResult(succeeded, message, gumballMachine.getTheStateName(), gumballMachine.getCount());
    }

    @Override
    public TransitionResult ejectQuarter() {
        String message = "You can't eject, you haven't inserted a quarter yet";
        boolean succeeded = false;
        return new TransitionResult(succeeded, message, gumballMachine.getTheStateName(), gumballMachine.getCount());
    }

    @Override
    public TransitionResult turnCrank() {
        String message = "You turned, but there are no gumballs";
        boolean succeeded = false;
        return new TransitionResult(succeeded, message, gumballMachine.getTheStateName(), gumballMachine.getCount());
    }

    @Override
    public TransitionResult dispense() {
        String message = "No gumball dispensed";
        boolean succeeded = false;
        return new TransitionResult(succeeded, message, gumballMachine.getTheStateName(), gumballMachine.getCount());
    }

    @Override
    public TransitionResult refill(int balls) {
        gumballMachine.changeTheStateTo(GumballMachineState.NO_QUARTER);
        gumballMachine.setCount(balls);
        System.out.println(balls + "  IN REFILL soldOutState " + gumballMachine.getCount() + " " + gumballMachine.getTheStateName());
        String message = "Machine refilled";
        boolean succeeded = true;
        return new TransitionResult(succeeded, message, gumballMachine.getTheStateName(), gumballMachine.getCount());
    }

    @Override
    public String getTheName() {
        return GumballMachineState.OUT_OF_GUMBALLS.name();
    }

}