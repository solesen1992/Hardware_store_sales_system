# Hardware store sales system
Sales system for a hardware store.

The project is based on the hardware store Vestbjerg Byggecenter A/S. It involves a building center that sells construction materials and other equipment. The system must be able to create orders, keep track of products, information about the orders, and the customers, etc.

It's from my education in Computer Science (1st semester). The project was a part of a group project made in the winter of 2023/2024.

# Video of Graphic user interface
https://github.com/user-attachments/assets/c32e9160-b306-47a1-849b-68544050a105

# Documentation
This system is designed to manage products, orders, customers, and related operations in a retail context. Here's a summary of its main functionalities:

## Overview
### Product Management:
- Product: Represents a general product with attributes such as name, type, price, stock amount, brand, and barcode.
- SimpleProduct: A type of product that does not have individual copies. It includes additional details like package size.
- UniqueProduct: A type of product with individual copies, each identified by a serial number. Includes warranty details and a list of product copies.

### Product Copies:
- ProductCopy: Represents an individual instance of a unique product, identified by a serial number. This allows tracking of specific items, such as serial-numbered electronics.

### Order Management:
- Order: Represents a customer's order, which contains multiple order lines, each linking a product and quantity. Includes details about the customer and the employee processing the order.
- OrderLine: Represents a line item in an order, detailing the quantity and product involved. It calculates the subtotal for the line based on the quantity and product price.

### Customer Management:
- Customer: A base class representing a customer with common attributes such as name, phone number, email, and address.
- Private: Extends Customer to represent individual customers, with an additional attribute for a unique customer number.
- Business: Extends Customer to represent business customers, including additional attributes like company name, company number, VAT number, and contact person.

### Container Classes:
- CustomerContainer: A singleton class that manages a collection of customers, providing methods to add, find, and list customers.
- ProductContainer: A singleton class that manages a collection of products, including both simple and unique products. Provides methods to add, find, and list products.

### Application:
- TryMe: The main class that initializes test data for products, customers, and product copies. It also sets up the user interface by launching the GUI application.

### System Functionality
- Add and Manage Products: Users can add products to the system, whether they are simple products (e.g., screws, ladders) or unique products (e.g., grills, washing machines with serial numbers).
- Track Product Copies: For unique products, each individual copy is tracked by its serial number, allowing precise inventory management and warranty tracking.
- Process Orders: Orders are created with multiple line items, allowing users to specify quantities of products. The system calculates subtotals and manages order details.
- Manage Customers: Customers are managed by their details, with specific types for individual and business customers. The system supports adding, finding, and listing customers.
- Singleton Containers: The system uses singleton patterns for managing collections of customers and products, ensuring there is only one instance of each container throughout the application.

### Use Case Scenarios
- Retail Store: Manage inventory of both regular and unique products, track individual product copies, and process customer orders.
- Warehouse: Keep track of stock levels, manage products with serial numbers, and handle orders for various products.
- Customer Service: Access customer information, handle orders, and track warranty details for unique products.

Overall, this system is designed to efficiently manage various aspects of a retail or inventory-based business, integrating product management, customer management, and order processing into a cohesive system.
