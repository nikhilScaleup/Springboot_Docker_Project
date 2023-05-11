function getAllCustomers() {
    fetch('http://localhost:8080/customers')
        .then(response => response.json())
        .then(data => {
            const tableBody = document.querySelector('#all-customers tbody');
            tableBody.innerHTML = '';
            data.forEach(customer => {
                const row = `<tr>
                                <td>${customer.id}</td>
                                <td>${customer.name}</td>
                                <td>${customer.email}</td>
                                <td>${customer.phone}</td>
                            </tr>`;
                tableBody.insertAdjacentHTML('beforeend', row);
            });
        });
}

function getCustomerDetails() {
    const customerId = document.querySelector('#customer-id').value;
    fetch(`http://localhost:8080/customers/${customerId}`)
        .then(response => response.json())
        .then(data => {
            const customerDetails = document.querySelector('#customer-details');
            if (data) {
                customerDetails.innerHTML = `<p><strong>Name:</strong> ${data.name}</p>
                                                <p><strong>Email:</strong> ${data.email}</p>
                                                <p><strong>Phone:</strong> ${data.phone}</p>`;
            } else {
                customerDetails.innerHTML = '<p>Customer not found</p>';
            }
        });
}

function getCustomerOrders() {
    const customerId = document.querySelector('#customer-orders-id').value;
    fetch(`http://localhost:8080/customers/${customerId}/orders`)
        .then(response => response.json())
        .then(data => {
            const tableBody = document.querySelector('#customer-orders tbody');
            tableBody.innerHTML = '';
            data.forEach(order => {
                const row = `<tr>
                                <td>${order.id}</td>
                                <td>${order.orderDate}</td>
                                <td>${order.price}</td>
                            </tr>`;
                tableBody.insertAdjacentHTML('beforeend', row);
            });
        });
}

function getCustomerOrder() {
    const customerId = document.querySelector('#customer-order-id').value;
    const orderId = document.querySelector('#order-id').value;
    fetch(`http://localhost:8080/customers/${customerId}/orders/${orderId}`)
        .then(response => response.json())
        .then(data => {
            const customerOrderDetails = document.querySelector('#customer-order-details');
            if (data) {
                customerOrderDetails.innerHTML = `<p><strong>Product:</strong> ${data.product}</p>
                                                    <p><strong>Quantity:</strong> ${data.quantity}</p>
                                                    <p><strong>Price:</strong> ${data.price}</p>`;
            } else {
                customerOrderDetails.innerHTML = '<p>Order not found</p>';
            }
        });
}

document.addEventListener('DOMContentLoaded', () => {
    getAllCustomers();
});
