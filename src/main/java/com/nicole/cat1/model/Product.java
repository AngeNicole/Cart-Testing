package com.nicole.cat1.model;

import javax.persistence.Entity;
import javax.persistence.Id;

    @Entity
    public class Product {
        @Id
        private Integer id;

        private String name;

        private String description;

        private Long price;

        private String manufacturer;

        public Product() {
        }

        public Product(String name, String description, Long price, String manufacturer) {
            this.name = name;
            this.description = description;
            this.price = price;
            this.manufacturer = manufacturer;
        }

        public Product(Integer id, String name, String description, Long price, String manufacturer) {
            this.id = id;
            this.name = name;
            this.description = description;
            this.price = price;
            this.manufacturer = manufacturer;
        }


        public Integer getId() {
            return id;
        }

        public void setId(Integer id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public Long getPrice() {
            return price;
        }

        public void setPrice(Long price) {
            this.price = price;
        }

        public String getManufacturer() {
            return manufacturer;
        }

        public void setManufacturer(String manufacturer) {
            this.manufacturer = manufacturer;
        }
    }
