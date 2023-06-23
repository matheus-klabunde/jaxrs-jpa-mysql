angular.module('myApp', [])	
  .controller('UserController', ['$http', function($http, urlBase) {
    let self = this;

    self.users = [];
    self.newUser = {};
    self.isEditing = false;
    self.editingUser = {};

    self.getUsers = function() {
      $http.get('http://localhost:8080/jaxrs/webapi/users')
        .then(function(response) {
          self.users = response.data;
        })
        .catch(function(error) {
          console.error('Error retrieving users:', error);
        });
    };

    self.createUser = function() {
      let newUser = {
        name: self.newUser.name,
        email: self.newUser.email
      };

      $http.post('http://localhost:8080/jaxrs/webapi/users', newUser)
        .then(function(response) {
          self.users.push(response.data);
          self.newUser = {};
          self.getUsers();
        })
        .catch(function(error) {
          console.error('Error creating user:', error);
        });
    };

    self.editUser = function(user) {
      self.isEditing = true;
      self.editingUser = angular.copy(user);
    };

    self.cancelEdit = function() {
      self.isEditing = false;
      self.editingUser = {};
    };

    self.updateUser = function() {
      var updatedUser = {
        id: self.editingUser.id,
        name: self.editingUser.name,
        email: self.editingUser.email
      };

      $http.put('http://localhost:8080/jaxrs/webapi/users/' + self.editingUser.id, updatedUser)
        .then(function(response) {
          self.isEditing = false;
          self.editingUser = {};
          self.getUsers();
        })
        .catch(function(error) {
          console.error('Error updating user:', error);
        });
    };

    self.deleteUser = function(user) {
      if (confirm('Are you sure you want to delete this user?')) {
        $http.delete('http://localhost:8080/jaxrs/webapi/users/' + user.id)
          .then(function(response) {
            let index = self.users.indexOf(user);
            console.log(index);
            if (index !== -1) {
              self.users.splice(index, 1);
            }
          })
          .catch(function(error) {
            console.error('Error deleting user:', error);
          });
      }
    };

    self.getUsers();
  }]);

