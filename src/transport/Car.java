package transport;

public class Car {
    public static class Insurance {
        private final int validityPeriodInsurance;
        private final double costInsurance;
        private final String numberInsurance;

        public Insurance(int validityPeriodInsurance, double costInsurance, String numberInsurance) {
            if (validityPeriodInsurance > 0) {
                this.validityPeriodInsurance = validityPeriodInsurance;
            } else {
                this.validityPeriodInsurance = 365;
            }
            this.costInsurance = costInsurance;
            if (numberInsurance != null) {
                this.numberInsurance = numberInsurance;
            } else {
                this.numberInsurance = "888888888";
            }
        }

        public Insurance() {
            this(0, 5000, null);
        }

        public int getValidityPeriodInsurance() {
            return validityPeriodInsurance;
        }

        public double getCostInsurance() {
            return costInsurance;
        }

        public String getNumberInsurance() {
            return numberInsurance;
        }

        public void checValidityPeriod() {
            if (validityPeriodInsurance > validityPeriodInsurance) {
                System.out.println("Нужно срочно ехать оформлять новую страховку!");
            }
        }

        public void checkNumber() {
            if (numberInsurance.length() != 9) {
                System.out.println("Номер страховки некорректный!");
            }
        }
    }

    public static class Key {
        private final boolean remoteEngineStart;
        private final boolean keylessAccess;

        public Key(boolean remoteEngineStart, boolean keylessAccess) {
            this.remoteEngineStart = remoteEngineStart;
            this.keylessAccess = keylessAccess;
        }

        public Key() {
            this(true, true);
        }

        public boolean isRemoteEngineStart() {
            return remoteEngineStart;
        }

        public boolean isKeylessAccess() {
            return keylessAccess;
        }

    }

    private final String brand;
    private final String model;
    private final String productionYear;
    private final String productionCountry;
    private final int numberOfSeats;
    private final String bodyType;
    private String color;
    private String engineVolume;
    private String transmission;

    private String registrationNumber;

    private String typeOfRubber;
    private Key key;
    private Insurance insurance;

    public String getBrand() {
        return brand;
    }

    public String getModel() {
        return model;
    }

    public String getProductionYear() {
        return productionYear;
    }

    public String getProductionCountry() {
        return productionCountry;
    }

    public int getNumberOfSeats() {
        return numberOfSeats;
    }

    public String getBodyType() {
        return bodyType;
    }


    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getEngineVolume() {
        return engineVolume;
    }

    public void setEngineVolume(String engineVolume) {
        this.engineVolume = engineVolume;
    }

    public String getTransmission() {
        return transmission;
    }

    public void setTransmission(String transmission) {
        this.transmission = transmission;
    }

    public String getRegistrationNumber() {
        return registrationNumber;
    }

    public void setRegistrationNumber(String registrationNumber) {
        this.registrationNumber = registrationNumber;
    }

    public String getTypeOfRubber(boolean summerTires) {
        return typeOfRubber;
    }

    public void setTypeOfRubber(boolean summerTires) {
        if (summerTires == true) {
            this.typeOfRubber = "Летняя резина";
        } else {
            this.typeOfRubber = "Зимняя резина";
        }
    }

    public Key getKey() {
        return key;
    }

    public void setKey(Key key) {
        this.key = key;
    }

    public Insurance getInsurance() {
        return insurance;
    }

    public void setInsurance(Insurance insurance) {
        this.insurance = insurance;
    }

    public Car(String brand,
               String model,
               String productionYear,
               String productionCountry,
               int numberOfSeats,
               String bodyType,
               String color,
               String engineVolume,
               String transmission,
               String registrationNumber,
               boolean summerTires,
               Key key,
               Insurance insurance) {
        if (brand != null && !brand.isEmpty() && !brand.isBlank()) {
            this.brand = brand;
        } else {
            this.brand = "default";
        }
        if (model != null && !model.isEmpty() && !model.isBlank()) {
            this.model = model;
        } else {
            this.model = "default";
        }
        if (productionYear != null && !productionYear.isEmpty() && !productionYear.isBlank()) {
            this.productionYear = productionYear;
        } else {
            this.productionYear = "2000";
        }
        if (productionCountry != null && !productionCountry.isEmpty() && !productionCountry.isBlank()) {
            this.productionCountry = productionCountry;
        } else {
            this.productionCountry = "Россия";
        }
        if (numberOfSeats >= 0) {
            this.numberOfSeats = numberOfSeats;
        } else {
            this.numberOfSeats = Math.abs(numberOfSeats);
        }
        if (bodyType != null && !bodyType.isEmpty() && !bodyType.isBlank()) {
            this.bodyType = bodyType;
        } else {
            this.bodyType = "Пикап";
        }
        if (color != null && !color.isEmpty() && !color.isBlank()) {
            this.color = color;
        } else {
            this.color = "белый";
        }
        if (engineVolume != null && !engineVolume.isEmpty() && !engineVolume.isBlank()) {
            this.engineVolume = engineVolume;
        } else {
            this.engineVolume = "1,5 л";
        }
        if (transmission != null && !transmission.isEmpty() && !transmission.isBlank()) {
            this.transmission = transmission;
        } else {
            this.transmission = "Полуавтомат";
        }

        if (registrationNumber != null && !registrationNumber.isEmpty() && !registrationNumber.isBlank()) {
            this.registrationNumber = registrationNumber;
        } else {
            this.registrationNumber = "х000хх000";
        }
        if (summerTires == true) {
            this.typeOfRubber = "Летняя резина";
        } else {
            this.typeOfRubber = "Зимняя резина";
        }
        if (key != null) {
            this.key = key;
        } else {
            this.key = new Key();
        }
        if (insurance != null) {
            this.insurance = insurance;
        } else {
            this.insurance = new Insurance();
        }

    }

    public void changeTiresForSeasonalOnes() {
        if (typeOfRubber == "Зимняя резина") {
            typeOfRubber = "Летняя резина";
        } else {
            typeOfRubber = "Зимняя резина";
        }
    }

    public boolean checkRegistrationNumber() {
        //х000хх000
        if (this.registrationNumber.length() != 9) {
            System.out.println("Регистрационный номер неверный.");

            return false;
        }
        char[] chars = registrationNumber.toCharArray();
        if (!Character.isAlphabetic(chars[0]) || !Character.isAlphabetic(chars[4]) || !Character.isAlphabetic(chars[5])) {
            return false;
        }
        return Character.isDigit(chars[1]) && Character.isDigit(chars[2]) && Character.isDigit(chars[3]) && Character.isDigit(chars[6]) && Character.isDigit(chars[7]) && Character.isDigit(chars[8]);
    }

    @Override
    public String toString() {
        return "Car{" +
                "brand ='" + brand + '\'' +
                ", model ='" + model + '\'' +
                ", productionYea r='" + productionYear + '\'' +
                ", productionCountry ='" + productionCountry + '\'' +
                ", numberOfSeats = " + numberOfSeats +
                ", bodyType ='" + bodyType + '\'' +
                ", color ='" + color + '\'' +
                ", engineVolume ='" + engineVolume + '\'' +
                ", transmission ='" + transmission + '\'' +
                ", registrationNumber ='" + registrationNumber + '\'' +
                ", typeOfRubber ='" + typeOfRubber + '\'' +
                ", key = удаленный запуск двигателя " + key.keylessAccess +
                ", = бесключевой доступ " + key.remoteEngineStart +
                ", insurance = срок действия " + insurance.validityPeriodInsurance +
                " дней, = стоимость " + insurance.costInsurance +
                " руб., = номер " + insurance.numberInsurance +
                '}';
    }
}
