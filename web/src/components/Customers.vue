<template>
  <nav class="navbar navbar-expand-lg navbar-light bg-light">
    <div class="container-fluid">
      <a class="navbar-brand" href="#">Navbar</a>
      <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
      </button>
      <div class="collapse navbar-collapse" id="navbarNav">
        <ul class="navbar-nav">
          <li class="nav-item">
            <a class="nav-link active" aria-current="page" href="#">Home</a>
          </li>
          <li class="nav-item">
            <a class="nav-link" href="#">Features</a>
          </li>
          <li class="nav-item">
            <a class="nav-link" href="#">Pricing</a>
          </li>
          <li class="nav-item">
            <a class="nav-link disabled" href="#" tabindex="-1" aria-disabled="true">Disabled</a>
          </li>
        </ul>
      </div>
    </div>
  </nav>

  <table class="table">
    <thead>
    <tr>
      <th scope="col">#</th>
      <th scope="col">İsim</th>
      <th scope="col">Soyisim</th>
      <th scope="col">Adres</th>
      <th scope="col">Telefon</th>
      <th scope="col">E-mail</th>
      <th scope="col">Düzenle</th>
    </tr>
    </thead>
    <tbody>
    <tr v-for="item in customers" :key="item.id">
      <th scope="row">{{ item.id }}</th>
      <td>{{ item.customer_name }}</td>
      <td>{{ item.customer_surname }}</td>
      <td>{{ item.customer_address }}</td>
      <td>{{ item.customer_phone }}</td>
      <td>{{ item.customer_email }}</td>
      <td>
        <button type="button" class="btn btn-primary" data-bs-toggle="modal" data-bs-target="#exampleModal" @click="getCustomersModal(item);getPetsModal(item);">
          User Login
        </button>
      </td>
    </tr>
    </tbody>
  </table>



    <!-- Modal -->
    <div class="modal fade " id="exampleModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
      <div class="modal-dialog modal-lg">
        <div class="modal-content">
          <div class="modal-header">
            <h5 v-show="!editmode" class="modal-title text-danger" id="exampleModalLabel">Kullanıcı Detay</h5>
            <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
          </div>
          <div class="modal-body">
            <label>Kullanıcı id: {{customerId}}</label><br>
            <label>Kullanıcı adi: {{customerName}}</label><br>
            <label>Kullanici soyadi: {{customerSurname}}</label><br>

            <br><br>
            <table class="table">
              <thead>
              <tr>
                <th scope="col">#</th>
                <th scope="col">Pet İsmi</th>
                <th scope="col">Pet Yaşı</th>
                <th scope="col">Pet Cinsiyeti</th>
                <th scope="col">Pet Cinsi</th>
              </tr>
              </thead>
              <tbody>
              <tr v-for="pets in petsDetail" :key="pets.id">
                <th scope="row">#</th>
                <td>{{ pets.pet_name }}</td>
                <td>{{ pets.pet_age }}</td>
                <td>{{ pets.pet_sex }}</td>
                <td>{{ pets.pet_type }}</td>
              </tr>
              </tbody>
            </table>

          </div>
          <div class="modal-footer">
            <button type="button" class="btn btn-warning" data-bs-dismiss="modal">Close</button>
          </div>
        </div>
      </div>
    </div>

</template>

<script>
import {getAllCustomers, getCustomerById} from "@/common/customer.service";
import {getAllPets} from "@/common/pet.service";

export default {
  name: 'Customers',
  components: {},
  data() {
    return {
      editmode: false,
      customers: [],
      customersDetail: [],
      petsDetail: [],

      customerId:'',
      customerName:'',
      customerSurname:'',

    }
  },
  created() {
    this.getCustomers();
  },
  methods: {
    getCustomers() {
      getAllCustomers().then(response => {
        this.customers = response.data;
      })
    },
    getCustomersModal(item){
      getCustomerById(item.id).then(response => {
        this.customersDetail = response.data;
        this.customerId = this.customersDetail.id;
        this.customerName = this.customersDetail.customer_name;
        this.customerSurname = this.customersDetail.customer_surname;
      })
    },
    getPetsModal(item){
      getAllPets().then(response=>{
        console.log(response.data);
        this.petsDetail = response.data.filter(b => b.pet_customer_id === item.id);
        console.log("pets");
        console.log(this.petsDetail);
      })
    },
  }
}
</script>