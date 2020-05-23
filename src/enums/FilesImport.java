package enums;
//Class responsible for loading all files stored on the Files package
public enum FilesImport {
    /*
        GIVENNAME is a mix of names for women and men but just in case some day needs a name by gender, there are two
        more files for that
    * */
    GIVENNAME("./src/files/givenname.txt"),
    SURNAME("./src/files/surname.txt"),
    ANIMALILLNESS("./src/files/animalillness.txt"),
    ANIMALNAME("./src/files/animalname.txt"),
    NAMESMEN("./src/files/namesmen.txt"),
    NAMESWOMEN("./src/files/nameswomen.txt"),
    TASKIT("./src/files/task_it.txt"),
    TASKACCOUNTANT("./src/files/task_accountant.txt"),
	TASKSECRETARY("./src/files/task_secretary.txt");

    private final String directory;

    FilesImport(String directory) {
        this.directory = directory;
    }

    public String getDirectory() {
        return this.directory;
    }
}