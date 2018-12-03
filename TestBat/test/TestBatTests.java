
import org.junit.Test;
import static org.junit.Assert.*;

public class TestBatTests {

    @Test
    public void iceyHotTest() {
        IceHotClass ih = new IceHotClass();
        assertFalse( ih.icyHot( 10, 30 ) );
        assertTrue( ih.icyHot( -1, 120));
    }
}
