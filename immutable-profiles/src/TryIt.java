import com.example.profiles.*;

public class TryIt {
    public static void main(String[] args) {
        ProfileService svc = new ProfileService();
        UserProfile p = svc.createMinimal("u1", "a@b.com");
        System.out.println("Email: " + p.getEmail());
        System.out.println("=> In the solution, setters are gone and the object is immutable.");
    }
}
