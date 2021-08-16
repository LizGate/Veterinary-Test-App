import {get} from "@/common/api.service";


export function getCustomerById(id) {
    return get('customers/' + id);
}

export function getAllCustomers() {
    return get('customers');
}
