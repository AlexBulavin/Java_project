package Lesson7.Lesson7_4;

public interface I_My {
    int getUserID();

    default int getAdminID() {
        return 1;
    }
}
