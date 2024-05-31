-- 1
CREATE INDEX idx_purchase_supplier_id ON purchase (supplier_id);
CREATE INDEX idx_purchase_purchase_detail_id ON purchase (purchase_detail_id);
CREATE INDEX idx_supplier_id_name on supplier(id, name);
-- 2
CREATE INDEX idx_product_dish ON dish_ingredients (product_id, dish_id);
CREATE INDEX idx_dish_order ON order_dishes (dish_id, order_id);
--3
CREATE INDEX idx_booking_start_time ON booking (date_trunc('month', start_time));
CREATE INDEX idx_booking_table_id ON booking (table_id);
CREATE INDEX idx_table_data_id ON table_data (is_around_window, is_veranda);