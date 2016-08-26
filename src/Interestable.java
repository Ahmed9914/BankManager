/**
 * This interface allows us to assume that any class that implements (or extends a class that implements it)
 * to have a method called applyInterest
 */
//TODO: find a better name for this interface? Something that means "can apply interest upon"
public interface Interestable {
    void applyInterest();
}
