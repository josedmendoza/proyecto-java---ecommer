package com.project.ecommerce.service;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.project.ecommerce.ECommerceApplication;
import com.project.ecommerce.model.BillProduct;
import com.project.ecommerce.model.BillingDetail;
import com.project.ecommerce.model.ShoppingCart;
import com.project.ecommerce.model.User;
import com.project.ecommerce.repository.BillProductRepository;
import com.project.ecommerce.repository.iRepository.IBillProduct;
import com.project.ecommerce.repository.iRepository.IUserRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class BillProductService {

	private final BillProductRepository billPRepository;
	private final IUserRepository iUserRepository;
	private final IBillProduct iBillProduct;

	private static Logger log = LoggerFactory.getLogger(ECommerceApplication.class);

	// Metodo para obtener las facturas segun el id de un cliente
	public List<BillProduct> getB(Integer idUser) {

		List<BillProduct> listB = iBillProduct.getId(idUser);
		List<BillProduct> listS = new ArrayList<>();
		if (listB != null) {

			for (BillProduct list : listB) {
				BillProduct billS = new BillProduct();
				billS.setIdBillG(list.getIdBillG());
				billS.setUser(list.getUser());
				billS.setTotalPrice(list.getTotalPrice());
				billS.setTotalquantity(list.getTotalquantity());
				billS.setDetail(list.getDetail());
				listS.add(billS);
			}
			return listS;
		} else {
			return null;
		}
	}

	// Metodo para crear la cabecera de la factura
	public BillProduct createIdBill(ShoppingCart productsDetail) {
		log.info("producDetail service : {}", productsDetail);

		BillProduct dataBill = new BillProduct();

		Integer idCart = productsDetail.getIdCart();
		log.info("idCart en service: {}", idCart);
		User user = iUserRepository.getUser(idCart);

		log.info("user en service object bill: {}", user);
		dataBill.setUser(user);
		log.info("databill: {}", dataBill);

		return billPRepository.create(dataBill);
	}

	// Metodo para crear el cuerpo de la factura
	public BillProduct createB(BillProduct header, List<BillingDetail> createDetail) {

		BillProduct bill = new BillProduct();

		bill.setIdBillG(header.getIdBillG());
		bill.setUser(header.getUser());
		bill.setDetail(createDetail);

		Float totalP = 0f;
		Integer totalQ = 0;
		for (BillingDetail listDetail : createDetail) {

			totalP = totalP + listDetail.getPrice();
			totalQ = totalQ + listDetail.getQuantity();
		}
		bill.setTotalPrice(totalP);
		bill.setTotalquantity(totalQ);

		billPRepository.updateBillH(header, totalP, totalQ);

		return bill;

	}

}
