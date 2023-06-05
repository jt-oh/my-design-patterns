class Strategy {
    public static void main(String[] args) {
        PrisonersDilemmaGame game;

        StrategyI confessStrategy = new ConfessStrategy();
        StrategyI silentStrategy = new SilentStrategy();

        game = new PrisonersDilemmaGame(confessStrategy, confessStrategy);
        game.run();

        game = new PrisonersDilemmaGame(confessStrategy, silentStrategy);
        game.run();

        game = new PrisonersDilemmaGame(silentStrategy, confessStrategy);
        game.run();

        game = new PrisonersDilemmaGame(silentStrategy, silentStrategy);
        game.run();
    }
}

enum PrisonerAction {
    CONFESS,
    SILENT
}

class PrisonersDilemmaGame {
    private Prisoner prisonerA;
    private Prisoner prisonerB;

    public PrisonersDilemmaGame(StrategyI prisonerAStrategy, StrategyI prisonerBStrategy) {
        prisonerA = new Prisoner(prisonerAStrategy);
        prisonerB = new Prisoner(prisonerBStrategy);
    }

    public void run() {
        System.out.println("Start Game!");
        PrisonerAction prisonerAAction = prisonerA.decide();
        PrisonerAction prisonerBAction = prisonerB.decide();

        if (prisonerAAction == PrisonerAction.CONFESS && prisonerBAction == PrisonerAction.CONFESS) {
            System.out.println("    Both Confess: 5 years for each");
        } else if (prisonerAAction == PrisonerAction.CONFESS && prisonerBAction == PrisonerAction.SILENT) {
            System.out.println("    A Confess, B Silent: A free, B 10 years");
        } else if (prisonerAAction == PrisonerAction.SILENT && prisonerBAction == PrisonerAction.CONFESS) {
            System.out.println("    A Silent, B Confess: A 10 years, B free");
        } else if (prisonerAAction == PrisonerAction.SILENT && prisonerBAction == PrisonerAction.SILENT) {
            System.out.println("    Both Silent: 1 year for each");
        }

        System.out.println("End Game");
        System.out.println("");
    }
}

// Prisoner Class
class Prisoner {
    private StrategyI strategy;

    public Prisoner(StrategyI strategy) {
        this.strategy = strategy;
    }

    public PrisonerAction decide() {
        return strategy.execute();
    }
}

// Prisoner Strategy interface
interface StrategyI {
    public PrisonerAction execute();
}

// Concrete Prisoner Strategies
class ConfessStrategy implements StrategyI {
    @java.lang.Override
    public PrisonerAction execute() {
        return PrisonerAction.CONFESS;
    }
}

class SilentStrategy implements StrategyI {
    @java.lang.Override
    public PrisonerAction execute() {
        return PrisonerAction.SILENT;
    }
}

