package com.project.ecommerce.controller;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.ecommerce.ECommerceApplication;
import com.project.ecommerce.model.BillProduct;
import com.project.ecommerce.model.BillingDetail;
import com.project.ecommerce.model.ShoppingCart;
import com.project.ecommerce.repository.ListProductCartRepository;
import com.project.ecommerce.service.BillProductService;
import com.project.ecommerce.service.BillingDetailService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
@RequestMapping("/billproduct")
public class BillProductController {

	private final BillProductService billPService;
	private final BillingDetailService billingDetailService;
	private final ListProductCartRepository listProductCartRepository;

	private static Logger log = LoggerFactory.getLogger(ECommerceApplication.class);

	// Metodo para obtener Facturas creadas
	@GetMapping("/getbill/{iduser}")
	public ResponseEntity<?> getbillProduct(@PathVariable(name = "iduser") Integer idUser) {

		try {

			List<BillProduct> getBills = billPService.getB(idUser);
			if (getBills.isEmpty()) {
				return ResponseEntity.badRequest().body("No se encuentraron facturas");
			} else {
				return ResponseEntity.ok(getBills);
			}
		} catch (Exception e) {
			return ResponseEntity.badRequest().body("/Error: " + e.getMessage());
		}

	}

	// Metodo para generar factuas
	@PostMapping("/createbill")
	public ResponseEntity<?> createBill(@RequestBody ShoppingCart productsDetail) {
		// Creamos el ID de la factura
		BillProduct createIdBill = billPService.createIdBill(productsDetail);
		// LLenamos la tabla BillDetail con los datos del json mas le idBill
		List<BillingDetail> createDetail = billingDetailService.saveDetail(productsDetail, createIdBill);
		// se genera la factura
		BillProduct createBill = billPService.createB(createIdBill, createDetail);
		// luego de generar la factura borrar los datos en listproductcart
		listProductCartRepository.delete(productsDetail.getIdCart());

		return ResponseEntity.ok(createBill);

	}

	// Metodo para generar factura masiva de clientes
	@PostMapping("/createbills")
	public ResponseEntity<?> createBills(@RequestBody List<ShoppingCart> productsCart) {

		try {

			List<BillProduct> bills = new ArrayList<>();
			// Recorremos los productos de todos los clientes a generarles una factura
			for (ShoppingCart listA : productsCart) {
//				BillProduct bill = new BillProduct();
				// se genera el id de la factura por cliente
				BillProduct createIdB = billPService.createIdBill(listA);
				// se carga los datos de la factura y productos asociados a esa factura en
				// billDetail
				List<BillingDetail> createDetails = billingDetailService.saveDetail(listA, createIdB);
				// generamos la factura
				BillProduct createBillM = billPService.createB(createIdB, createDetails);
				bills.add(createBillM);
				// luego de generar la factura borrar los datos en listproductcart
				listProductCartRepository.delete(listA.getIdCart());
			}
			return ResponseEntity.ok(bills);

		} catch (Exception e) {

			return ResponseEntity.badRequest().body("/Error: " + e.getMessage());
		}

	}

}
