public enum ActionEnum {
    ACTION1("Сделай селфи и отправь его здесь!"),
    ACTION2("Прочитай вслух последнее сообщение из чата."),
    // Добавьте еще действия по желанию
    // ...
    ;

    private final String action;

    ActionEnum(String action) {
        this.action = action;
    }

    public String getAction() {
        return action;
    }
}