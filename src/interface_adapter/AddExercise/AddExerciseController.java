package interface_adapter.AddExercise;

import use_case.add_exercise.AddExerciseInputBoundary;
import use_case.add_exercise.AddExerciseInputData;

public class AddExerciseController {
    final AddExerciseInputBoundary addExerciseUseCaseInteractor;

    public AddExerciseController(AddExerciseInputBoundary addExerciseUseCaseInteractor){
        this.addExerciseUseCaseInteractor = addExerciseUseCaseInteractor;
    }

    public void execute(String name, float calorie){
        AddExerciseInputData inputData = new AddExerciseInputData(name, calorie);
        addExerciseUseCaseInteractor.execute(inputData);
    }

}
