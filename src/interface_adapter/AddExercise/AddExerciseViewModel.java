package interface_adapter.AddExercise;

import interface_adapter.ViewModel;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class AddExerciseViewModel extends ViewModel {
    public static final String ADD_BUTTON_LABEL = "Add";
    public static final String FOOD_LABEL = "Choose food";
    public static final String WEIGHT_LABEL = "Enter weight (g)";

    private AddExerciseState state = new AddExerciseState();

    public AddExerciseViewModel(){super("add exercise");}

    public void setState(AddExerciseState state){
        this.state = state;
    }
    private final PropertyChangeSupport support = new PropertyChangeSupport(this);
    public void firePropertyChanged(){
        support.firePropertyChange("state", null, this.state);
    }

    public void addPropertyChangeListener(PropertyChangeListener listener){
        support.addPropertyChangeListener(listener);
    }

    public AddExerciseState getState(){
        return state;
    }
}
