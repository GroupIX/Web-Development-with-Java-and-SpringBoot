package com.example.demo.Supplier;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service //This is a service class. Instantiates this class so that it becomes a spring bean.
//This is dependency injection and have split these to layers.
public class SupplierService {
    private final SupplierRepository supplierRepository;

    @Autowired
    public SupplierService(SupplierRepository supplierRepository){
        this.supplierRepository = supplierRepository;
    }
    public List<Supplier> getSuppliers() {
        return supplierRepository.findAll(

        );
    }

    public void addNewSupplier(Supplier supplier) {
        Optional<Supplier> supplierOptional =
        supplierRepository.findSupplierByEmail(supplier.getEmail());
        if(supplierOptional.isPresent()){
            throw  new IllegalStateException("Supplier already exists!");
        }

        supplierRepository.save(supplier);

        //System.out.println(supplier);
    }

    public void deleteSupplier(Long supplierId) {
       // supplierRepository.findById(supplierId);
        boolean exists = supplierRepository.existsById(supplierId);
        if(!exists){
            throw new IllegalStateException("Supplier with id " + supplierId + " does not exist");
        }
        supplierRepository.deleteById(supplierId);
    }

    @Transactional
    //Allows you to use the getters and setters to check if you can or cannot update
    //

    public void updateSupplier(Long supplierId,
                               String name,
                               String email){
        Supplier supplier = supplierRepository.findById(supplierId) //Check whether supplier exists using Id
                .orElseThrow(() -> new IllegalStateException("supplier with id " + supplierId + " does not exist"));//if they do not exist, throw exception

        if(name != null && name.length() > 0 //If name is not null and length is greater than 0, and
                //name provided is not same as the existing name set the name.
        && !Objects.equals(supplier.getName(), name)){
            supplier.setName(name);
        }

        if(email != null && name.length() > 0 //If email is not null and length is greater than 0, and
                //name provided is not same as the existing name set the name.
                && !Objects.equals(supplier.getEmail(), email)) {
            Optional<Supplier> supplierOptional = supplierRepository
                    .findSupplierByEmail(email);
            //Check that the email has not been taken
            if (supplierOptional.isPresent()){
                //If taken, throw exception
                throw new IllegalStateException("Email is taken");
            }
            supplier.setEmail(email);
        }

    }
}
