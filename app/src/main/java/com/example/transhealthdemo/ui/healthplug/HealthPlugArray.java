package com.example.transhealthdemo.ui.healthplug;

public class HealthPlugArray {

        private String title;
        private String description;
        private String category;
        private String author;
        private String date;

    public HealthPlugArray(String title, String description, String category, String author, String date) {
        this.title = title;
        this.description = description;
        this.category = category;
        this.author = author;
        this.date = date;
    }


        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public String getAuthor() {
            return author;
        }

        public void setAuthor(String author) {
            this.author = author;
        }

        public String getDate() {
            return date;
        }

        public void setDate(String date) {
            this.date = date;
        }

    @Override
    public String toString() {
        return  title + "\n\n" + description + "\n\n" + category + "\n\n" + author + "\n\n" + date;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
}
