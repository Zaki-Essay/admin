package com.ensah.admin.web;


import com.ensah.admin.dtos.UserDto;
import com.ensah.admin.exceptions.UserNotFoundException;
import com.ensah.admin.services.IAdminService;
import com.ensah.admin.utils.DashboardInfos;
import com.ensah.admin.utils.HttpResults;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.List;


@CrossOrigin("*")
@RestController
public class AdminController {

    @Autowired
    private IAdminService adminService;



    @GetMapping("/users")
    public List<UserDto> users(){
        return adminService.listUsers();
    }
    @GetMapping("/users/search")
    public List<UserDto> searchUsers(@RequestParam(name = "keyword",defaultValue = "") String keyword){
        return adminService.searchUsers("%"+keyword+"%");
    }



    @GetMapping("/userExist")
    public ResponseEntity<UserDto> findUserByUsersname(@RequestParam(name = "username",defaultValue = "") String userName) throws UserNotFoundException {

            return ResponseEntity.ok(adminService.findUserByUserName(userName));
    }
    @GetMapping("/users/{id}")
    public UserDto getUser(@PathVariable(name = "id") Long userId) throws UserNotFoundException {
        return  adminService.getUser(userId);
    }
    @PostMapping("/users")
    public HttpResults saveUser(@RequestBody UserDto userDto){

         adminService.saveUser(userDto);
         return new HttpResults("saved");
    }
    @PutMapping("/users/{id}")
    public HttpResults updateUser(@PathVariable Long id, @RequestBody UserDto userDto){
        userDto.setId(id);
        adminService.updateUser(userDto);
        return new HttpResults("updated");
    }
    @DeleteMapping("/users/{id}")
    public void deleteCustomer(@PathVariable Long id){
        adminService.deleteUser(id);
    }


    @GetMapping(path="/userImage/{id}",produces = MediaType.IMAGE_JPEG_VALUE)
    public byte[] getPhoto(@PathVariable("id") Long id) throws Exception{

        return adminService.getPhoto(id);
    }
    @PostMapping(path = "/uploadPhoto/{id}")
    public void uploadPhoto(MultipartFile file, @PathVariable Long id) throws Exception{
        adminService.uploadPhoto(file, id);
    }


    @GetMapping("/listUsers")
    public List<UserDto> getNormalUsers(@RequestParam("role") String role){
        List<UserDto> allList = adminService.listUsers();
        List<UserDto> userList = new ArrayList();
        if("user".equals(role)){

            allList.forEach(userDto -> {
                    if (userDto.getAuthorities().stream().anyMatch(r -> r.getId()==2)){
                        userList.add(userDto);

                    }


            });
        }

        if("admin".equals(role)){

            allList.forEach(userDto -> {
                    if (userDto.getAuthorities().stream().anyMatch(r -> r.getId()==1)){
                        userList.add(userDto);

                    }


            });
        }

        return userList;


    }
    @GetMapping("/dashboard")
    public DashboardInfos getInfosForDashboard(){






        List<UserDto> userDtos = adminService.listUsers();

        DashboardInfos dashboardInfos = new DashboardInfos(0,0);

        userDtos.forEach((userDto -> {


            if(userDto.getAuthorities().stream().anyMatch(role -> role.getId()==2)){
                dashboardInfos.setUsersNumber(dashboardInfos.getUsersNumber()+1);
            }

            if (userDto.getAuthorities().stream().anyMatch(role -> role.getId()==1)){
                dashboardInfos.setAdminsNumber(dashboardInfos.getAdminsNumber()+1);
            }


        }));


        return dashboardInfos;
    }

}
