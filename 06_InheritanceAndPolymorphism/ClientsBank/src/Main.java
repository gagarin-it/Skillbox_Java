import ClientsBank.IndividualEntrepreneur;
import ClientsBank.LegalPerson;
import ClientsBank.NaturalPerson;

public class Main {

  public static void main(String[] args) {
    NaturalPerson naturalPerson = new NaturalPerson(5000);
    System.out.println(naturalPerson.accountBalance());
    naturalPerson.addMoney(500);
    System.out.println(naturalPerson.accountBalance());
    naturalPerson.accountInformation();
    naturalPerson.removalMoney(2000);
    naturalPerson.accountInformation();

    System.out.println("-------------------------------------");

    LegalPerson legalPerson = new LegalPerson(100000);
    System.out.println(legalPerson.accountBalance());
    legalPerson.addMoney(25000);
    legalPerson.accountInformation();
    legalPerson.removalMoney(48000);
    legalPerson.accountInformation();

    System.out.println("-------------------------------------");

    IndividualEntrepreneur individualEntrepreneur = new IndividualEntrepreneur(50000);
    System.out.println(individualEntrepreneur.accountBalance());
    individualEntrepreneur.accountInformation();
    individualEntrepreneur.removalMoney(4000);
    System.out.println(individualEntrepreneur.accountBalance());
    individualEntrepreneur.addMoney(900);
    System.out.println(individualEntrepreneur.accountBalance());
    individualEntrepreneur.addMoney(9000);
    System.out.println(individualEntrepreneur.accountBalance());
  }
}
