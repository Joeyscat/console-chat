package fun.oook.webchat;

/**
 * @author ZhouYu
 * @version 1.0.0
 * @since 2020/4/28
 */
public class BBTest {
    private String name;
    private String email;

    public static Builder builder() {
        return new Builder();
    }

    public BBTest(final String name, final String email) {
        this.name = name;
        this.email = email;
    }

    public static class Builder {

        private String name;
        private String email;

        public Builder name(String name) {
            this.name = name;
            return this;
        }

        public Builder email(String email) {
            this.email = email;
            return this;
        }

        public BBTest build() {
            return new BBTest(this.name, this.email);
        }
    }

    public static void main(String[] args) {
        final BBTest build = BBTest.builder()
                .name("")
                .email("")
                .build();
    }
}
