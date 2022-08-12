
package com.Admin.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Admin.controller.model.Assesment;



@Repository
public interface AdminRepository extends JpaRepository<Assesment,Integer> {

}



