package enums;

public enum FilesImport {
    /*
        GIVENNAME is a mix of names for women and men but just in case some day needs a name by gener, there are two
        more files for that
    * */
    GIVENNAME("./src/names/givenname.txt"),
    SURNAME("./src/names/surname.txt"),
    ANIMALNAME("./src/names/animalname.txt"),
    NAMESMEN("./src/names/namesmen.txt"),
    NAMESWOMEN("./src/names/nameswomen.txt");

    private final String direcotry;

    FilesImport(String directory) {
        this.direcotry = directory;
    }

    public String getDirecotry() {
        return this.direcotry;
    }
}