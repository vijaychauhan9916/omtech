package com.consMang.transaction.product.service;

import java.util.List;

import com.consMang.transaction.product.model.ProductMasterModel;

public interface IProductService {

	long createNew(ProductMasterModel productMasterModel) throws Exception;
	void updateProduct(ProductMasterModel productMasterModel) throws Exception;
	ProductMasterModel findProductById(Long productId) throws Exception;
	List<ProductMasterModel> getAllProduct() throws Exception;
	void removeById(Long productId)throws Exception;
}
