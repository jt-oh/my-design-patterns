class TemplateMethod {
    public static void main(String[] args) {
        AbstractPipeline pipeline;

        pipeline = new AWSPipeline();
        pipeline.runPipeline();

        pipeline = new AzurePipeline();
        pipeline.runPipeline();
    }
}

// Abstract Class
abstract class AbstractPipeline {
    // Template Method
    public final void runPipeline() {
        System.out.println("-- start pipeline --");
        testCode();
        buildCode();
        deployCode();
        System.out.println("-- end pipeline --");
        System.out.println("");
    }

    // Abstract Primitives
    abstract protected void testCode();
    abstract protected void buildCode();
    abstract protected void deployCode();
}

// SubClasses
class AWSPipeline extends AbstractPipeline {
    // overridden Primitives
    final protected void testCode() {
        System.out.println("test code on the AWS EC2 Container!");
    }

    final protected void buildCode() {
        System.out.println("build code using AWS CodeBuild!");
    }

    final protected void deployCode() {
        System.out.println("deploy code using AWS CodeDeploy to Prod Env on AWS Lambda!");
    }
}

class AzurePipeline extends AbstractPipeline {
    // overridden Primitives
    final protected void testCode() {
        System.out.println("test code on the Azure VirtualMachines!");
    }

    final protected void buildCode() {
        System.out.println("build code using Azure Artifacts!");
    }

    final protected void deployCode() {
        System.out.println("deploy code using Azure DeploymentEnvironments to Prod Env on Azure Function!");
    }
}