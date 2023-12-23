package ru.itis301.labs;

public class Building implements Buildable {

    private Stages stages = new Stages();

    @Override
    public void build() {
        boolean buildFinishFlag = buildProcess();
        if (buildFinishFlag) System.out.println("Строительство завершено");
        else System.out.println("Строительство заблокировано");
    }

    private boolean buildProcess() {
        try {
            checkProjectCompleteable();
            System.out.println(1 + " Этап завершен");
            int count = 1;
            while (!stages.isEnd()) {
                try {
                    count++;
                    checkStageCompleteable(stages.nextToCheck());
                    stages.next();
                    System.out.println(count + " Этап завершен");
                } catch (StageRejectedException e2) {
                    count--;
                    stages.next();
                    stages.setCurrentStage();
                    stages.prev();
                    System.out.println(e2.getMessage());
                }
            }
        } catch (ProjectRejectedException e) {
            System.out.println(e.getMessage());
            return false;
        }
        System.out.println("5 Этап завершен");
        return true;
    }


    private void checkProjectCompleteable() throws ProjectRejectedException {
        if (stages.getHead().getStatus() == Status.REJECTED) {
            throw new ProjectRejectedException("Проект забракован");
        }
    }

    private void checkStageCompleteable(Stage stage) throws StageRejectedException {
        if (stage.getStatus() == Status.REJECTED) {
            throw new StageRejectedException("Этап был забракован. Начинаем с предыдущего этапа");
        }
    }

}
