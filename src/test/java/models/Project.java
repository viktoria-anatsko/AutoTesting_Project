package models;

public class Project {
    private String username;
    private String password;
    private boolean addedProduct;
    private boolean shoppingCart;

    public static class Builder {
        private Project newProject;

        public Builder() {
            this.newProject = new Project();
        }

        public Builder withUsername(String username) {
            newProject.username = username;
            return this;
        }
        public Builder withPassword(String password) {
            newProject.password = password;
            return this;
        }
        public Builder withAddedProduct(Boolean addedProduct) {
            newProject.addedProduct = addedProduct;
            return this;
        }
        public Builder withShoppingCart(Boolean shoppingCart) {
            newProject.shoppingCart = shoppingCart;
            return this;
        }

        public Project build() {
            return newProject;
        }
    }
}
