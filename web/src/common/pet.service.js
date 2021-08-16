import {get} from "@/common/api.service";


export function getPetsById(id) {
    return get('pets/' + id);
}

export function getAllPets() {
    return get('pets');
}
