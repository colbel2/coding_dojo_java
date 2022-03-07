package com.belmar.savetravels.repo;



import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.belmar.savetravels.models.ExpenseItem;

@Repository
public interface ExpenseItemRepo extends CrudRepository<ExpenseItem, Long> {

}
