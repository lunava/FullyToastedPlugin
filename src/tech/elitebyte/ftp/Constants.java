package tech.elitebyte.ftp;


enum Track {
    Citizenship, Magic, BloodMagic, Thaumaturgy, Sorcery, Technology, Machining, Engineering, Science, Patronage;

    public String[] ranks;
    public double[] coolDownTimes;

    Track() {
        switch (this) {
            case Citizenship:
                ranks = new String[]{
                        "Plebeian",
                        "Wanderer",
                        "Citizen",
                        "Adventurer",
                        "Legend",
                        "Village Idiot"
                };
                coolDownTimes = new double[]{
                  0, 30, 60, 30, 30
                };
                break;
            case Magic:
                ranks = new String[]{
                        "Acolyte",
                        "Apprentice",
                        "Mage",
                        "Adept",
                        "Magus",
                        "Wizard",
                        "Archmage"
                };
                coolDownTimes = new double[]{
                  30, 60, 30, 40, 30, 60, 60
                };
                break;
            case BloodMagic:
                ranks = new String[]{
                        "Blood Letter",
                        "Sangainist",
                        "Blood Leech",
                        "Blood Lord"
                };
                coolDownTimes = new double[]{
                  30, 60, 30, 60
                };
                break;
            case Thaumaturgy:
                ranks = new String[]{
                        "Golemancer",
                        "Crimson Preator",
                        "Void Walker",
                        "Thaumaturgist"
                };
                coolDownTimes = new double[]{
                  60, 30, 60, 30
                };

                break;
            case Sorcery:
                ranks = new String[]{
                        "Shaman",
                        "Totem",
                        "Witch / Warlock",
                        "Werewolf / Vampire"
                };
                coolDownTimes = new double[] {
                        30, 60, 60, 60
                };
                break;
            case Technology:
                ranks = new String[]{
                        "Laborer",
                        "Tester",
                        "Tinkerer",
                        "Journeyman",
                        "Mechanic",
                        "Technician",
                        "Inventor"
                };
                coolDownTimes = new double[]{
                  30, 30, 30, 30, 30, 60, 60
                };
                break;
            case Machining:
                ranks = new String[]{
                        "Trackman",
                        "Machinist",
                        "Millwright",
                        "Conductor"
                };
                coolDownTimes = new double[]{
                  30, 60, 30, 60
                };
                break;
            case Engineering:
                ranks = new String[]{
                        "Specialist",
                        "Engineer",
                        "Roboticist",
                        "Cosmonaut"
                };
                coolDownTimes = new double[]{
                  30, 30, 30, 0
                };
                break;
            case Science:
                ranks = new String[]{
                        "Professor",
                        "Physicist / Chemist",
                        "Networker",
                        "Mad Scientist"
                };
                coolDownTimes = new double[]{
                  30, 0, 0, 30
                };
                break;
            case Patronage:
                ranks = new String[] {
                        "Knight",
                        "Baron / Baroness",
                        "Lord / Lady",
                        "Prince / Princess",
                        "President / Prime Minister",
                        "King / Queen",
                        "Emperor",
                        "Notch",
                        "Demi-God",
                        "Demon",
                        "Sphinx",
                        "Almighty",
                        "Demon King",
                        "God / Buddha"
                };
                coolDownTimes = new double[] {
                  60, 60, 60, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0
                };
                break;
        }
    }

}

