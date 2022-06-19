/**
 * 
 */
package com.practise.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.practise.model.Project;

/**
 * @author Sameer Kadgaye
 *
 */
@Repository
public interface ProjectRepository extends JpaRepository<Project, Long>{

}
