
using Microsoft.AspNetCore.Mvc;
using SPASample.Models;

namespace SPASample.Controllers
{
    public class HomeController : Controller
    {

        public IActionResult Index()
        {
            return View();
        }

        public IActionResult Home()
        {
            List<Employee> employees = new List<Employee>();
            employees.Add(new Employee
            {
                Name = "AAAAAA",
                Age = 30,
                Id = 1001
            });
            employees.Add(new Employee
            {
                Name = "BBBBBB",
                Age = 41,
                Id = 1002
            });
            employees.Add(new Employee
            {
                Name = "CCCCCCC",
                Age = 35,
                Id = 1003
            });


            HomeViewModel homeViewModel = new HomeViewModel();
            homeViewModel.Employees = employees;
            return View(homeViewModel);
        }

        public IActionResult About()
        {
            return View();
        }

        public IActionResult Settings()
        {
            return View();
        }

    }
}
