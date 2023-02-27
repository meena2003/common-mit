public class Terminal {
    private MitSystem mitSystem;
    private CommandFormat commandFormat;

    public Terminal() {
        mitSystem = new MitSystem();
        commandFormat = new CommandFormat();
    }

    public void run() {

        while (true) {
            printPrompt();
            try {
                commandFormat.getCommandLine();
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
                System.out.println();
                continue;
            }

            switch (commandFormat.getCommand()) {
                case "list" :
                    try {
                        mitSystem.printListOfFiles(commandFormat.getDirectoryPath());
                        break;
                    } catch (NullPointerException e) {
                        System.out.println(e.getMessage());
                    }

                case "hash" :
                    mitSystem.printHashOfFiles(commandFormat.getDirectoryPath());
                    break;
                case "zlib" :
                    mitSystem.compressFiles(commandFormat.getDirectoryPath());
                    break;
            }
            System.out.println();
        }
    }

    private void printPrompt() {
        System.out.print("$ ");
    }
}