public enum TruthEnum {
    QUESTION1("Какое самое странное место, где ты когда-либо спал(а)?"),
    QUESTION2("Какой самый смешной момент в твоей жизни?"),
    // Добавьте еще вопросы по желанию
    // ...
    ;

    private final String question;

    TruthEnum(String question) {
        this.question = question;
    }

    public String getQuestion() {
        return question;
    }
}