import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class SortVolumeTest {

    @Test
    void sortVolume() {

        Shape cube = new Cube(3.0);
        Shape sphere = new Sphere(8.0);
        Shape cylinder = new Cylinder(2.0, 3.0);

        List<Shape> shapeList = new ArrayList<>();
        shapeList.add(cube);
        shapeList.add(sphere);
        shapeList.add(cylinder);

        Map<Shape, Double> result = new LinkedHashMap<>();
        result.put(cube, 27.0);
        result.put(cylinder, 37.69911184307752);
        result.put(sphere, 2144.660584850632);

        assertEquals(result, Main.SortVolume(shapeList));
    }
}