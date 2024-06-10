import React, { useEffect, useState } from "react";
import { Table } from "antd";
import { useNavigate, useLocation } from "react-router-dom";

function App() {
  const location = useLocation();
  const navigate = useNavigate();
  const params = new URLSearchParams(location.search);
  const initialPage = parseInt(params.get("page")) || 1;

  const columns = [
    {
      title: "Name",
      dataIndex: "name",
      key: "name",
    },
    {
      title: "Region",
      dataIndex: "region",
      key: "region",
    },
    {
      title: "Currency",
      dataIndex: "currency",
      key: "currency",
    },
    {
      title: "Population",
      dataIndex: "population",
      key: "population",
    },
  ];

  const data = [
    {
      name: "United States",
      region: "North America",
      currency: "USD",
      population: 331002651,
    },
    {
      name: "Canada",
      region: "North America",
      currency: "CAD",
      population: 37742154,
    },
    {
      name: "Mexico",
      region: "North America",
      currency: "MXN",
      population: 128932753,
    },
    {
      name: "Brazil",
      region: "South America",
      currency: "BRL",
      population: 212559417,
    },
    {
      name: "Argentina",
      region: "South America",
      currency: "ARS",
      population: 45195774,
    },
    {
      name: "United Kingdom",
      region: "Europe",
      currency: "GBP",
      population: 67886011,
    },
    {
      name: "France",
      region: "Europe",
      currency: "EUR",
      population: 65273511,
    },
    {
      name: "Germany",
      region: "Europe",
      currency: "EUR",
      population: 83783942,
    },
    {
      name: "Italy",
      region: "Europe",
      currency: "EUR",
      population: 60359546,
    },
    {
      name: "Spain",
      region: "Europe",
      currency: "EUR",
      population: 46754778,
    },
    {
      name: "Russia",
      region: "Europe",
      currency: "RUB",
      population: 145934462,
    },
    {
      name: "China",
      region: "Asia",
      currency: "CNY",
      population: 1439323776,
    },
    {
      name: "India",
      region: "Asia",
      currency: "INR",
      population: 1380004385,
    },
    {
      name: "Japan",
      region: "Asia",
      currency: "JPY",
      population: 126476461,
    },
    {
      name: "South Korea",
      region: "Asia",
      currency: "KRW",
      population: 51269185,
    },
    {
      name: "Australia",
      region: "Oceania",
      currency: "AUD",
      population: 25499884,
    },
    {
      name: "New Zealand",
      region: "Oceania",
      currency: "NZD",
      population: 4822233,
    },
    {
      name: "Nigeria",
      region: "Africa",
      currency: "NGN",
      population: 206139589,
    },
    {
      name: "Egypt",
      region: "Africa",
      currency: "EGP",
      population: 102334404,
    },
    {
      name: "South Africa",
      region: "Africa",
      currency: "ZAR",
      population: 59308690,
    },
    {
      name: "Kenya",
      region: "Africa",
      currency: "KES",
      population: 53771296,
    },
    {
      name: "Turkey",
      region: "Asia",
      currency: "TRY",
      population: 84339067,
    },
    {
      name: "Saudi Arabia",
      region: "Asia",
      currency: "SAR",
      population: 34813871,
    },
    {
      name: "Iran",
      region: "Asia",
      currency: "IRR",
      population: 83992949,
    },
    {
      name: "Indonesia",
      region: "Asia",
      currency: "IDR",
      population: 273523615,
    },
    {
      name: "Pakistan",
      region: "Asia",
      currency: "PKR",
      population: 220892340,
    },
    {
      name: "Bangladesh",
      region: "Asia",
      currency: "BDT",
      population: 164689383,
    },
    {
      name: "Thailand",
      region: "Asia",
      currency: "THB",
      population: 69799978,
    },
    {
      name: "Vietnam",
      region: "Asia",
      currency: "VND",
      population: 97338579,
    },
    {
      name: "Philippines",
      region: "Asia",
      currency: "PHP",
      population: 109581078,
    },
    {
      name: "Malaysia",
      region: "Asia",
      currency: "MYR",
      population: 32365999,
    },
  ];

  const [current, setCurrent] = useState(initialPage);
  const [records, setRecords] = useState(data);

  useEffect(() => {
    const newPage = parseInt(params.get("page")) || 1;
    setCurrent(newPage);
  }, [location.search]);

  const handleTableChange = (pagination) => {
    const { current } = pagination;
    setCurrent(current);
    navigate(`?page=${current}`);
  };

  return (
    <Table
      dataSource={records}
      columns={columns}
      pagination={{
        current: current,
        pageSize: 10, // Set your page size here
      }}
      onChange={handleTableChange}
    />
  );
}

export default App;