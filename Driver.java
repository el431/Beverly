import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Driver {
    private static ArrayList<Dog> dogList = new ArrayList<Dog>();
    private static ArrayList<Monkey> monkeyList = new ArrayList<>();

    public static void main(String[] args) {
    	Scanner scanner = new Scanner(System.in);
		 
        initializeDogList();
        initializeMonkeyList();

        String selection = "";
        while (!selection.equalsIgnoreCase("q")) {
            displayMenu();
            selection = scanner.nextLine();

            switch (selection) {
                case "1":
                    intakeNewDog(scanner);
                    break;
                case "2":
                    intakeNewMonkey(scanner);
                    break;
                case "3":
                    reserveAnimal(scanner);
                    break;
                case "4":
                    printAnimals("dog");
                    break;
                case "5":
                    printAnimals("monkey");
                    break;
                case "6":
                    printAnimals("available");
                    break;
                case "q":
                    System.out.println("Exiting the application. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid selection. Please try again.");
            }
        }
        
        scanner.close();
    }
    
    // This method prints the menu options
    public static void displayMenu() {
        System.out.println("\n\n");
        System.out.println("\t\t\t\tRescue Animal System Menu");
        System.out.println("[1] Intake a new dog");
        System.out.println("[2] Intake a new monkey");
        System.out.println("[3] Reserve an animal");
        System.out.println("[4] Print a list of all dogs");
        System.out.println("[5] Print a list of all monkeys");
        System.out.println("[6] Print a list of all animals that are not reserved");
        System.out.println("[q] Quit application");
        System.out.println();
        System.out.println("Enter a menu selection");
    }


    // Adds dogs to a list for testing
    public static void initializeDogList() {
        Dog dog1 = new Dog("Spot", "German Shepherd", "male", "1", "25.6", "05-12-2019", "United States", "intake", false, "United States");
        Dog dog2 = new Dog("Rex", "Great Dane", "male", "3", "35.2", "02-03-2020", "United States", "Phase I", false, "United States");
        Dog dog3 = new Dog("Bella", "Chihuahua", "female", "4", "25.6", "12-12-2019", "Canada", "in service", true, "Canada");

        dogList.add(dog1);
        dogList.add(dog2);
        dogList.add(dog3);
    }


    // Adds monkeys to a list for testing
    //Optional for testing
    
    public static void initializeMonkeyList() {
    	 Monkey monkey1 = new Monkey("George", "Capuchin", "male", "2", "8.3", "07-08-2020", "Brazil", "in service", false, "United States");
         monkeyList.add(monkey1);
    }


    // Complete the intakeNewDog method
    // The input validation to check that the dog is not already in the list
    // is done for you
    public static void intakeNewDog(Scanner scanner) {
        System.out.println("What is the dog's name?");
        String name = scanner.nextLine();
        for(Dog dog: dogList) {
            if(dog.getName().equalsIgnoreCase(name)) {
                System.out.println("\n\nThis dog is already in our system\n\n");
                return; //returns to menu
            }
        }

        // Add the code to instantiate a new dog and add it to the appropriate list
        System.out.println("Enter the dog's breed:");
        String breed = scanner.nextLine();
        System.out.println("Enter the dog's gender:");
        String gender = scanner.nextLine();
        System.out.println("Enter the dog's age:");
        String age = scanner.nextLine();
        System.out.println("Enter the dog's weight:");
        String weight = scanner.nextLine();
        System.out.println("Enter the dog's acquisition date:");
        String acquisitionDate = scanner.nextLine();
        System.out.println("Enter the dog's acquisition country:");
        String acquisitionCountry = scanner.nextLine();
        System.out.println("Enter the dog's training status:");
        String trainingStatus = scanner.nextLine();
        System.out.println("Is the dog reserved? (true/false):");
        boolean reserved = scanner.nextBoolean();
        scanner.nextLine(); // Consume newline
        System.out.println("Enter the dog's in-service country:");
        String inServiceCountry = scanner.nextLine();

        Dog newDog = new Dog(name, breed, gender, age, weight, acquisitionDate, acquisitionCountry, trainingStatus, reserved, inServiceCountry);
        dogList.add(newDog);
        System.out.println("New dog added to the system.");
    }


        // Complete intakeNewMonkey
	//Instantiate and add the new monkey to the appropriate list
        // For the project submission you must also  validate the input
	// to make sure the monkey doesn't already exist and the species type is allowed
        public static void intakeNewMonkey(Scanner scanner) {
            System.out.println("What is the monkey's name?");
            for (Monkey monkey : monkeyList) {
                if (monkey.getName().equalsIgnoreCase(name)) {
                    System.out.println("\n\nThis monkey is already in our system\n\n");
                    return; // Return to menu
                }
            }
            
            System.out.println("Enter the monkey's species (e.g., Capuchin, Macaque, Tamarin):");
            String species = scanner.nextLine();
            System.out.println("Enter the monkey's gender:");
            String gender = scanner.nextLine();
            System.out.println("Enter the monkey's age:");
            String age = scanner.nextLine();
            System.out.println("Enter the monkey's weight:");
            String weight = scanner.nextLine();
            System.out.println("Enter the monkey's acquisition date:");
            String acquisitionDate = scanner.nextLine();
            System.out.println("Enter the monkey's acquisition country:");
            String acquisitionCountry = scanner.nextLine();
            System.out.println("Enter the monkey's training status:");
            String trainingStatus = scanner.nextLine();
            System.out.println("Is the monkey reserved? (true/false):");
            boolean reserved = scanner.nextBoolean();
            scanner.nextLine(); // Consume newline
            System.out.println("Enter the monkey's in-service country:");
            String inServiceCountry = scanner.nextLine();

            Monkey newMonkey = new Monkey(name, species, gender, age, weight, acquisitionDate, acquisitionCountry, trainingStatus, reserved, inServiceCountry);
            monkeyList.add(newMonkey);
            System.out.println("New monkey added to the system.");
        }

        // Complete reserveAnimal
        // You will need to find the animal by animal type and in service country
        public static void reserveAnimal(Scanner scanner) {
            System.out.println("Enter the type of animal to reserve (dog/monkey):");
            String type = scanner.nextLine();
            System.out.println("Enter the in-service country:");
            String inServiceCountry = scanner.nextLine();
            
            if (type.equalsIgnoreCase("dog")) {
                for (Dog dog : dogList) {
                    if (dog.getInServiceLocation().equalsIgnoreCase(inServiceCountry) && !dog.isReserved()) {
                        dog.setReserved(true);
                        System.out.println(dog.getName() + " has been reserved.");
                        return;
                    }
                }

            } else if (type.equalsIgnoreCase("monkey")) {
                for (Monkey monkey : monkeyList) {
                    if (monkey.getInServiceLocation().equalsIgnoreCase(inServiceCountry) && !monkey.isReserved()) {
                        monkey.setReserved(true);
                        System.out.println(monkey.getName() + " has been reserved.");
                        return;
                    
                }
                    
                    
            } 
            
            
        }
            
            System.out.println("No available animals found for reservation.");
     } 
        
        

        // Complete printAnimals
        // Include the animal name, status, acquisition country and if the animal is reserved.
	// Remember that this method connects to three different menu items.
        // The printAnimals() method has three different outputs
        // based on the listType parameter
        // dog - prints the list of dogs
        // monkey - prints the list of monkeys
        // available - prints a combined list of all animals that are
        // fully trained ("in service") but not reserved 
	// Remember that you only have to fully implement ONE of these lists. 
	// The other lists can have a print statement saying "This option needs to be implemented".
	// To score "exemplary" you must correctly implement the "available" list.
        public static void printAnimals(String listType) {
        	if (listType.equalsIgnoreCase("dog")) {
                for (Dog dog : dogList) {
                    System.out.println(dog);
                }
        	} else if (listType.equalsIgnoreCase("monkey")) {
                for (Monkey monkey : monkeyList) {
                    System.out.println(monkey);
                }
            } else if (listType.equalsIgnoreCase("available")) {
                System.out.println("Available animals:");
                for (Dog dog : dogList) {
                    if (dog.getTrainingStatus().equalsIgnoreCase("in service") && !dog.isReserved()) {
                        System.out.println(dog);
                    }
                }
                for (Monkey monkey : monkeyList) {
                    if (monkey.getTrainingStatus().equalsIgnoreCase("in service") && !monkey.isReserved()) {
                        System.out.println(monkey);
                    }
                }
            } else {   
                System.out.println("The method printAnimals needs to be implemented");

            }
        }
    }
