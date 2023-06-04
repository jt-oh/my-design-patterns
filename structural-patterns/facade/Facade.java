class Facade {
    public static void main(String[] args) {
        CICDPiplineTool cicdTool = new CICDPiplineTool();

        cicdTool.runPipeline();
    }
}

// Facade Class
class CICDPiplineTool {
    private CodeTester tester;
    private CodeAnalyzer analyzer;
    private CodeBuilder builder;
    private CodeDeployer deployer;

    public CICDPiplineTool() {
        tester = new CodeTester();
        analyzer = new CodeAnalyzer();
        builder = new CodeBuilder();
        deployer = new CodeDeployer();
    }

    public void runPipeline() {
        System.out.println("-- start pipeline --");

        tester.test();
        analyzer.analyze();
        builder.build();
        deployer.deploy();

        System.out.println("-- end pipeline --");
    }
}

// Sub Classes
class CodeTester {
    public void test() {
        System.out.println("Do test Code!");
    }
}

class CodeAnalyzer {
    public void analyze() {
        System.out.println("Do analyze Code!");
    }
}

class CodeBuilder {
    public void build() {
        System.out.println("Do build Code!");
    }
}

class CodeDeployer {
    public void deploy() {
        System.out.println("Do deploy Code to Production Env!");
    }
}