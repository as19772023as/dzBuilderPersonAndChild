public class Main {
    public static void main(String[] args) {
        Person mom = new PersonBuilder()
                // .setName("Анна")
                .setSurname("Вольф")
                .setAge(31)
                .setAddress("Сидней")
                .build();
        System.out.println(mom);

        System.out.println("age - " + mom.hasAge());
        System.out.println("address - " + mom.hasAddress());

        Person son = mom.newChildBuilder()
                .setName("Антошка")
                .setAge(10)
                .build();
        System.out.println("У " + mom + " есть сын, " + son + "\n");

        mom.happyBirthday();
        mom.getAge().ifPresent(i -> System.out.println("Вы стали старше, с днем рождения! Вам " + i));

        try {
            // Не хватает обяхательных полей
            new PersonBuilder().build();
        } catch (IllegalStateException e) {
            e.printStackTrace();
        }

        try {
            // Возраст недопустимый
            new PersonBuilder().setAge(-100).build();
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        }
    }
}