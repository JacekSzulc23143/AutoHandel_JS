package project.autohandel;

public class ClientDatabase {

    String[] firstNames = {"Jacek", "Przemek", "Robert", "Paweł", "Piotr", "Rafał", "Tomasz", "Karol", "Arek",
            "Bartosz", "Marek", "Darek", "Filip", "Roland", "Michał", "Maciej", "Józef", "Ryszard", "Roman", "Joanna",
            "Anna", "Julia", "Patrycja", "Weronika", "Marta", "Sylwia", "Alicja", "Adrianna", "Agnieszka", "Aleksandra",
            "Jagoda", "Barbara", "Monika", "Oliwia", "Martyna", "Ewa", "Renata", "Teresa", "Katarzyna", "Inez"};
    String[] lastNames = {"Szulc", "Kowalski", "Kamiński", "Brzozowski", "Pepliński", "Figurski", "Karabin", "Armata",
            "Woźniak", "Komenda", "Krawczyk", "Wiśniewski", "Piwowski", "Nowak", "Szymański", "Wójcik", "Kowalczyk",
            "Lewandowski", "Dąbrowski", "Kozłowski", "Jankowski", "Mazur", "Kaczmarek", "Grabowski", "Zieliński",
            "Rutkowski", "Jarząbek", "Baran", "Ostrowski", "Marciniak", "Michalak", "Bąk", "Zawadzki", "Dudek",
            "Jakubowski", "Pietrzak", "Wilk", "Ryba", "Belka", "Stella"};

    Human[] clients;

    // Case "5". Zakres bazy danych klientów.
    public ClientDatabase(int extent) {
        clients = new Human[extent];
        for (int i = 0; i < clients.length; i++) {
            clients[i] = clientGenerator();
        }
    }

    // Case "5". Generator klientów.
    public Human clientGenerator() {
        int randomFirstName, randomLastName;
        String name;
        Double randomCash;
        randomFirstName = (int) ((Math.random() * (firstNames.length))); // generowanie imienia
        randomLastName = (int) ((Math.random() * (lastNames.length))); // generowanie nazwiska
        randomCash = (Math.random() * 350000.0) + 5000.0; // losowanie ilości pieniędzy
        randomCash = Double.parseDouble(String.valueOf(Math.round(randomCash))); // powoduje wyświetlenie pieniędzy do
        // jednej cyfry po przecinku
        name = firstNames[randomFirstName] + " " + lastNames[randomLastName];
        return new Human(name, randomCash);
    }

    // Case "5". Umożliwia wyświetlenie klientów od "0" numeru porządkowego.
    public void presentationClientsDatabase() {
        int i = 0;
        for (Human client : clients) {
            if (client != null) {
                System.out.println("(" + i + ") " + client.toString() + ", Ilość pieniędzy: " + client.getCash());
            }
            i++;
        }
//        System.out.println();
    }
}
