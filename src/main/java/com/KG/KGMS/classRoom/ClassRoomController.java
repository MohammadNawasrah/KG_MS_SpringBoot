package com.KG.KGMS.classRoom;

import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/classrooms") // Change the base request mapping
public class ClassRoomController {
    private final ClassRoomService classRoomService;

    public ClassRoomController(ClassRoomService classRoomService) {
        this.classRoomService = classRoomService;
    }

    @GetMapping
    public List<ClassRoom> getAllClassRooms() {
        return classRoomService.getAllClassRooms();
    }

    @GetMapping("/{id}")
    public ClassRoom getClassRoomById(@PathVariable Long id) {
        return classRoomService.getClassRoomById(id);
    }

    @PostMapping
    public ClassRoom createClassRoom(@RequestBody ClassRoom classRoom) {
        return classRoomService.createClassRoom(classRoom);
    }

    @PutMapping("/{id}")
    public ClassRoom updateClassRoom(@PathVariable Long id, @RequestBody ClassRoom classRoom) {
        classRoom.setClassId(id);
        return classRoomService.updateClassRoom(classRoom);
    }

    @DeleteMapping("/{id}")
    public void deleteClassRoom(@PathVariable Long id) {
        classRoomService.deleteClassRoom(id);
    }
}
