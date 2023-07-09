package Seminar_Project1;

public class Main {
    /*
    Создать структуру для хранения Номеров паспортов и Фамилий сотрудников организации.
    123456 Иванов
    321456 Васильев
    234561 Петрова
    234432 Иванов
    654321 Петрова
    345678 Иванов
    Вывести данные по сотрудникам с фамилией Иванов.
     */
    public static void main(String[] args) {
        Passports passports = new Passports();
        passports.addNote("123456", "Ivanov");
        passports.addNote("321456", "Alexander");
        passports.addNote("234561", "Cristiano");
        passports.addNote("234432", "Mbappe");
        passports.addNote("654321", "Messi");
        passports.addNote("345678", "Ivanov");

        System.out.println(passports.findByName("Ivanov"));
    }    
}
