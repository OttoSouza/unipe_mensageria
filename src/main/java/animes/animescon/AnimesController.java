//package animes.animescon;
//
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Map;
//
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//import com.google.common.collect.ImmutableMap;
//@RestController
//@RequestMapping("/animes")
//public class AnimesController {
//	private static final Map<Long, String> ANIMES = ImmutableMap.of(
//            1L, "One piece",
//            2L, "Naruto",
//            3L, "HunterxHunter"
//            	);
//
//    @GetMapping
//    public List<String> findAll() {
//        return new ArrayList<>(ANIMES.values());
//    }
//
//    @GetMapping(path = "/{id}")
//    public String findById(@PathVariable("id") Long id) {
//        return ANIMES.get(id);
//    }
//}
