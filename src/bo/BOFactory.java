package bo;

import bo.custom.impl.ProgramBOImpl;
import bo.custom.impl.RegisterProgramBOIpl;
import bo.custom.impl.StudentBOImpl;

public class BOFactory {
    private static BOFactory boFactory;

    public BOFactory() {
    }

    public static BOFactory getBoFactory() {
        if (boFactory == null) {
            boFactory = new BOFactory();
        }
        return boFactory;
    }

    public SuperBO getBO(BoTypes types) {
        switch (types) {
            case STUDENT:
                return new StudentBOImpl();
            case PROGRAM:
                return new ProgramBOImpl();
            case REGISTER_PROGRAM:
                return new RegisterProgramBOIpl();
            default:
                return null;
        }
    }

    public enum BoTypes {
        STUDENT, PROGRAM, REGISTER_PROGRAM
    }
}
