package com.example.demo.Supplier;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//In this project, we are using N-Tier approach of distributed systems.
//The project has three layers before we get to the database
//These are : API layer, Service layer and Data Access Layer.
//This is the API layer. It should communicate with the service layer to get data.

@RestController
@RequestMapping(path = "api/v1/Supplier")
public class SupplierController {

    private final SupplierService supplierService;

    @Autowired //Instantiates supplierService for us.

    public SupplierController(SupplierService supplierService)// supplerService is a constuctor
    {
        this.supplierService = supplierService;
    }

    @GetMapping
    //<POST> is used when you want to add new resources to your system.

    public List<Supplier> getSupplier(){
        return supplierService.getSuppliers();
    }

    @PostMapping //To map this request, i.e, to match it with where you want it.
//Take the request body and map it t the Supplier.
    //**@RequestBody annotation maps the HttpRequest body to a transfer or domain object,
    // enabling automatic deserialization of the inbound HttpRequest body onto a Java object.**
    public void registerNewSupplier(@RequestBody Supplier supplier){
        supplierService.addNewSupplier(supplier);
    }

    @DeleteMapping(path = "{supplierId}")
    public void deleteSupplier(
            @PathVariable("supplierId") Long supplierId){
        supplierService.deleteSupplier(supplierId);
    }

    @PutMapping(path = "{supplierId}")
    public void updateSupplier(
            @PathVariable("supplierId") Long supplierId,
            @RequestParam(required = false) String name,
            @RequestParam(required = false) String email){
        supplierService.updateSupplier(supplierId, name, email);
    }

}
