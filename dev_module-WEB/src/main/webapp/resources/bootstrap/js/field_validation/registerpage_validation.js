$(document).ready(function() {
    $('.registerForm').bootstrapValidator({
        message: 'This value is not valid',
        feedbackIcons: {
            valid: 'glyphicon glyphicon-ok',
            invalid: 'glyphicon glyphicon-remove',
            validating: 'glyphicon glyphicon-refresh'
        },
        fields: {
        	userName: {
                message: 'O usuário não é válido',
                validators: {
                    notEmpty: {
                        message: 'O usuário é obrigatório e não pode ser vazio'
                    },
                    stringLength: {
                        min: 6,
                        max: 30,
                        message: 'O usuário deve ter mais que 6 e menos que 30 caracters'
                    },
                }
            },
            email: {
                validators: {
                    notEmpty: {
                        message: 'O email é obrigatório e não pode ser vazio'
                    },
                    emailAddress: {
                        message: 'O email inserido não é válido'
                    }
                }
            },
            username_login: {
                validators: {
                    notEmpty: {
                        message: 'O email é obrigatório e não pode ser vazio'
                    },
                }
            },
            password_login: {
                validators: {
                    notEmpty: {
                        message: 'A senha é obrigatória e não pode ser vazio'
                    },
                }
            },
            password:{
            	validators: {
            		notEmpty: {
            			message: 'O campo senha é obrigatório e não pode ser vazio'
            		},
            		stringLength: {
                        min: 6,
                        max: 30,
                        message: 'A senha deve ter mais que 6 caracters'
                    }
            	}
            }
        }
    });
});